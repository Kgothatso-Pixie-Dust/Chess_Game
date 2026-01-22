import { dir } from 'console';
import { useAppContext }from '../../contexts/Context'
import { generateCandidates } from '../../reducer/actions/move';
import { get } from 'http';

const Piece = ({
    rank,
    file,
    piece,
}) => {

    const { appState, dispatch } = useAppContext();
    const { turn, position } = appState
    const currentPos = currentPosition[currentPosition.length -1]

    const getMoves = () => {
       
    }
        

    const onDragStart = e => {
        e.dataTransfer.effectAllowed = "move";
        e.dataTransfer.setData("text/plain",`${piece},${rank},${file}`)
        setTimeout(() => {
            e.target.style.display = 'none'
        },0)     
        if (turn !== piece[0]) {
            const candiateMoves = getMoves()
            console.log(candiateMoves)
        }

    }
    const onDragEnd = e => {
       e.target.style.display = 'block'
     }
 
    return (
        <div 
            className={`piece ${piece} p-${file}${rank}`}
            draggable={true}   
            onDragStart={onDragStart} 
            onDragEnd={onDragEnd}

        />)
}

export default Piece