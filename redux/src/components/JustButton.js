import React, { useState, Component } from 'react';
import { addUser, buttonClick } from '../redux/buttonTester/actions'
import { connect } from 'react-redux'
function JustButton(props) {
  const [formState, setFormState] = useState({ firstname: '' });

  const sendToRedux = () => {
    props.actions.addNewUser({ firstname: formState.firstname })//call action function
  }
  const updateLocalState = (event) => setFormState({ ...formState, [event.target.name]: event.target.value })
  return (
    <div>Sender
      <input onChange={updateLocalState} name='firstname' value={formState.firstname}></input>
      <button onClick={sendToRedux}>Sent to Redux</button>
    </div>
  )
}

function mapDispatchToProps(dispatch) {
  return {
    actions: {
      buttonState: (payload) => {
        dispatch(buttonClick(payload));
      },
      addNewUser: (payload) => {
        dispatch(addUser(payload));
      }
    }
  };
}

function mapStateToProps(reduxState) {
  return {
    buttonValue: reduxState.reducer1.formState.firstname
  };
}


export default connect(mapStateToProps, mapDispatchToProps)(JustButton);