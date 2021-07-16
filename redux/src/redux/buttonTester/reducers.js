import * as types from "./actionTypes";

const initialState = {
  formState:{firstname:"Pariwesh"}
};

function ButtonReducer(state = initialState, action) {
  switch (action.type) {
    case types.GET_CLICK_BUTTON:
      return {
        ...state,
        //buttonStatus: action.payload,
      };
    case types.ADD_USER:
      return {
        ...state,
        formState : action.user
      };
      //ajax call
    default:
      return state;
  }
}

export default ButtonReducer;