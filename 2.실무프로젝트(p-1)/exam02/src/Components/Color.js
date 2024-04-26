import { Component } from 'react';

class Color extends Component {
  state = {
    color: 'blue',
    subColor: 'black',
  };

  changeColor(color) {
    console.log(this);
  }

  render() {
    const changeColor = (color) => this.setState({ color });
    const changeSubColor = (color) =>
      this.setState((prevState) => ({ ...prevState, subColor: color }));
    const { color, subColor } = this.state;

    return (
      <>
        <div
          style={{ background: color, width: '100px', height: '100px' }}
        ></div>
        <button
          type="button"
          onClick={() => changeColor('red')}
          onContextMenu={() => changeSubColor('red')}
        >
          RED
        </button>
        <button
          type="button"
          onClick={() => changeColor('orange')}
          onContextMenu={() => changeSubColor('orange')}
        >
          ORANGE
        </button>
        <button
          type="button"
          onClick={() => changeColor('green')}
          onContextMenu={() => changeSubColor('green')}
        >
          GREEN
        </button>
        <div
          style={{ background: subColor, widdth: '50px', height: '50px' }}
        ></div>
      </>
    );
  }
}
