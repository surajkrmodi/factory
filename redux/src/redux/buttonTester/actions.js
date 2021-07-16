import * as types from "./actionTypes";

export function buttonClick(payload) {
  return {
    type: types.GET_CLICK_BUTTON,
    payload,
  };
}


export function addUser(user) {
  const action = { 
    type: types.ADD_USER,
    user,
  };
  return action;
}
