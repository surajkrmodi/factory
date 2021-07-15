import * as types from "./actionTypes";

export function buttonClick(payload) {
  return {
    type: types.GET_CLICK_BUTTON,
    payload,
  };
}
