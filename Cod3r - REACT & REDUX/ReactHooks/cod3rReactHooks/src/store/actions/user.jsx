export const login = (dispatch,loginName) => {
    return ()=>dispatch({type:'login', payload: {name:loginName}})
}