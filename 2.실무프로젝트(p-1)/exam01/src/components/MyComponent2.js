import { Component } from 'react';
import PropTypes from 'prop-types';

class MyComponent extends Component {
  static defaultProps = {
    name: '기본 이름',
  };

  static propTypes = {
    name: PropTypes.string,
    num: PropTypes.number.isRequired,
  };

  render() {
    // console.log(this.props);
    const { name, num, children } = this.props;

    return (
      <>
        <div>안녕하세요!, 제이름은 {name}입니다.</div>
        <div>제가 좋아하는 숫자는 {num}입니다.</div>
        {children}
      </>
    );
  }
}
MyComponent.defaultProps = {
  name: '기본이름',
};

MyComponent.propTypes = {
  name: PropTypes.string,
  num: PropTypes.number.isRequired,
};

export default MyComponent;
