import React from 'react';
import './registerPage.css';
import RegisterCard from '../../components/registerCard/registerCard';

const RegisterPage: React.FC = () => {
  return (
    <div className='register-page'>
      <RegisterCard />
    </div>
  );
};

export default RegisterPage;