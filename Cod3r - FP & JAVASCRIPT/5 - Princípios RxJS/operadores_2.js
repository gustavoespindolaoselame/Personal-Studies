const{ XMLHttpRequest } = require('xhr2')
const{ ajax } = require('rxjs/ajax')
const { map, concatAll } = require('rxjs/operators')

ajax({
    createXHR: () => new XMLHttpRequest(), 
    url: 'https://api.github.com/users/cod3rcursos/repos'}).
    pipe(
        map(resp=>resp.xhr.response),
        concatAll(),
        map(repo => repo.full_name)).
    subscribe(console.log)