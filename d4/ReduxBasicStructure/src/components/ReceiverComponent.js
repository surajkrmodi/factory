import React from 'react'
import { connect } from 'react-redux'

function ReceiverComponent(props) {
    console.log('value received from redux store='+ JSON.stringify(props));
    return (
        <div>Receiver
            {props.buttonValue}
        </div>
    )
}

function mapStateToProps(state) {//if you wish to receive state from redux store
    return {
        buttonValue: state.reducer1.buttonStatus,
    };
}
export default connect(mapStateToProps, null)(ReceiverComponent);
