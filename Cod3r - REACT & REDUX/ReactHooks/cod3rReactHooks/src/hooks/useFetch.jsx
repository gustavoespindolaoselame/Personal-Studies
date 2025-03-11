import React, { useEffect, useState } from 'react'

export const useFetch = (url, method = 'get') => {
    const [response, setReponse] = useState({
        data:null,
        loading:true
    })

    useEffect(function(){
        fetch(url,{ method }).
            then(resp => resp.json()).
                then(json => setReponse({
                    data:json,
                    loading:false
                }))
    },[url, method])
    return response;
}