const App = () => {
  const name = 'js';

  return (
    <>
      <div>신나는 컴포넌트!!</div>
      <div>신나는, {name && name} 공부</div>
      {name === 'React' && <h1>아! 재미있다!</h1>}
      <input type="text" />
    </>
  );
};
