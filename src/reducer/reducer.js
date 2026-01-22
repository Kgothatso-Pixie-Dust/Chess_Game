export const reducer = (state, action) => {
  switch (action.type) {
    case 'NEW_MOVE' : {
            let {position,movesList,turn} = state
            turn = turn === 'w' ? 'b' : 'w'
            position = [...position,action.payload.newPosition]
            return {
                ...state,
                turn,
                position : [...position,action.payload.newPosition], 
    }
    }
    default:
      return state;
}
}