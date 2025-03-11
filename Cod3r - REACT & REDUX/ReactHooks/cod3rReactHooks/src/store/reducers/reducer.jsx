export default (state,action) => {
    switch(action.type){
        case 'number_add2':
            return {...state, number:state.number + 2 }
        case 'number_multiplyby7':
            return {...state, number:state.number * 7 }
        case 'number_divideby25':
            return {...state, number:state.number /25 }
        case 'number_parsetoint':
            return {...state, number:parseInt(state.number)}
        case 'number_add4':
            return {...state, number:state.number + 4 }
        case 'number_addn':
            return {...state, number:state.number + action.payload.number}
        case 'login':
            return {...state, user: { name: action.payload.name}}
        default:
            return state;
    }
}