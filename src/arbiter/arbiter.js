import { getRookMoves } from '../arbiter/getMoves';

const arbiter = {
    getRegularMoves: function({position, piece, rank, file}) {
        return getRookMoves({position, piece, rank, file});
    }
}

export default arbiter;