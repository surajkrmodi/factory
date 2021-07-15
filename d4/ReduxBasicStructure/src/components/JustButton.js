import React, { Component } from 'react'
import { buttonClick } from '../redux/buttonTester/actions'
import { connect } from 'react-redux'
class JustButton extends Component {
    onPrev = () => {
        console.log(this.props.buttonValue);
        this.props.buttonState(!this.props.buttonValue)
    }
    render() {
        return (
            <div>
                <button onClick={this.onPrev}>PREV</button>
            </div>
        )
    }
}

function mapDispatchToProps(dispatch) {
    return {
      buttonState: (payload) => {
        dispatch(buttonClick(payload));
      },
    };
  }
  
  function mapStateToProps(state) {
    return {
      buttonValue: state.reducer1.buttonStatus,
    };
  }


export default connect(mapStateToProps,mapDispatchToProps)(JustButton);