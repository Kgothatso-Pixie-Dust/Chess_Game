
import './App.css';
import Board from './components/Board/Board';
import { reducer } from './reducer/reducer'
import { useReducer } from 'react'
import AppContext from './contexts/Context'

function App() {
  const [appState, dispatch] = useReducer(reducer, {x:20})

  const providerState = { appState, dispatch }
  return (
    <AppContext.Provider value={providerState}>
    <div className="App">
      <Board/>
    </div>
  </AppContext.Provider>
  )
}
export default App;