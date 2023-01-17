import "./App.css";
import { Button, Table, Container, Row, Col } from "react-bootstrap";

function App() {
  const board = [
    [5, 3, 0, 0, 7, 0, 0, 0, 0],
    [6, 0, 0, 1, 9, 5, 0, 0, 0],
    [0, 9, 8, 0, 0, 0, 0, 6, 0],
    [8, 0, 0, 0, 6, 0, 0, 0, 3],
    [4, 0, 0, 8, 0, 3, 0, 0, 1],
    [7, 0, 0, 0, 2, 0, 0, 0, 6],
    [0, 6, 0, 0, 0, 0, 2, 8, 0],
    [0, 0, 0, 4, 1, 9, 0, 0, 5],
    [0, 0, 0, 0, 8, 0, 0, 7, 9],
  ];

  function submit() {
    window.alert("Yay! you solved the sudoku!");
  }

  function reset() {
    window.location.reload();
  }

  function newboard() {
    window.location.reload();
  }

  return (
    <div className="container">
      <div className="centered">
        <h2>SUDOKU</h2>
        <br />
        <form>
          <div className="divtable">
            <Table className="table" bordered>
              <tbody>
                {board.map((row, rowi) => {
                  return (
                    <tr id={rowi}>
                      {row.map((col, coli) => {
                        if (col === 0)
                          return (
                            <td id={coli}>
                              <input
                                type={"number"}
                                min={1}
                                max={9}
                                onChange={(e) => {
                                  let num = e.target.value;
                                  if (num >= 1 && num <= 9)
                                    board[rowi][coli] = num;
                                  else e.target.value = "";
                                }}
                              ></input>
                            </td>
                          );
                        return (
                          <td id={coli} className="fixed">
                            {col}
                          </td>
                        );
                      })}
                    </tr>
                  );
                })}
              </tbody>
            </Table>
          </div>
          <Container className="footer" fluid>
            <Row className="row">
              <Col className="col">
                <Button variant="info" onClick={submit}>
                  Submit
                </Button>
              </Col>
              <Col className="col">
                <Button id="reset" variant="info" onClick={reset}>
                  Reset Board
                </Button>
              </Col>
              <Col className="col">
                <Button id="new" variant="info" onClick={newboard}>
                  New Board
                </Button>
              </Col>
            </Row>
          </Container>
        </form>
      </div>
    </div>
  );
}

export default App;
