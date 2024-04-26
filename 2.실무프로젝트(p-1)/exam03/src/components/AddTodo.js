import { useEffect } from 'react';
import { MdAdd } from 'react-icons/md';

const AddTodo = ({ onSubmit, onChange, todo, message }) => {
  useEffect(()=> {
    console.log("todo 값 변경");
  }, [todo]) // [...] 변화감지 기준
  return (
    <form autoComplete="off" onSubmit={onSubmit}>
      <input type="text" value={todo ?? ''} onChange={onChange} />
      <button type="submit">
        <MdAdd />
      </button>

      {message && <div>{message}</div>}
    </form>
  );
};

export default AddTodo;
