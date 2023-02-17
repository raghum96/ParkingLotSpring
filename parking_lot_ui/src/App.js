import logo from './logo.svg';
import './App.css';
import { Component } from 'react';

class App extends Component {

  state = {
    slot : {
      "id": "",
      "floorNumber": 0,
      "status": false
    }
  };

  async componentDidMount() {
    const response = await fetch('/viewSlot');
    const body = await response.json();
    this.setState({slot: body});
  }

  render() {
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <div className="App-intro">
              <h2>Slot</h2>
            <div> {this.state.slot.id}</div>  
            </div>
          </header>
        </div>
    );
  }

}

/*function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}*/

export default App;
