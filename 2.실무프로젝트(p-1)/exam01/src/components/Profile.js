import { useState } from 'react';

const Profile = () => {
  const [data, setData] = useState({
    name: '이이름',
    age: 40,
  });

  const changeprofile = () => {
    //data.name = '김이름';
    //data.age = 30;
    //setData(data);
    setData({ ...data, name: 'name' });
  };

  const { name, age } = data;
  return (
    <>
      <h1>{name}</h1>
      <h2>{age}</h2>
      <button type="button" onClick={changeprofile}>
        변경
      </button>
    </>
  );
};

export default Profile;
