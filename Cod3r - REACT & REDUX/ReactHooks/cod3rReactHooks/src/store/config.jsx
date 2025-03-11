import reducer from "./reducers/reducer"
import actions from "./actions/actions"

const initialState = {
    cart:[],
    products:[{},{}],
    user:null,
    //foco ...
    number:0
}

export default {
    initialState,
    reducer,
    actions
}


