import { Provider } from 'react-redux';
import './App.css';
import  JustButton from './components/JustButton'
import ReceiverComponent from './components/ReceiverComponent';
import store from './redux/store'
function App() {
  return (
    <Provider store={store}>
    <div className="App">
      <JustButton />
      <ReceiverComponent></ReceiverComponent>
    </div>
    </Provider>
  );
}

export default App;
