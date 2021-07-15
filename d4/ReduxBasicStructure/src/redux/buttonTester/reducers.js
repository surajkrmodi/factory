import * as types from "./actionTypes";

const initialState = {
  buttonStatus : false
};

function ButtonReducer(state = initialState, action) {
  switch (action.type) {
    case types.GET_CLICK_BUTTON:
      return {
        ...state,
        buttonStatus: action.payload,
      };
    default:
      return state;
  }
}

export default ButtonReducer;