import React from 'react';
import './loginPage.css';
import LoginCard from '../../components/loginCard/loginCard';

const LoginPage: React.FC = () => {
  return (
    <div className='login-page'>
      <LoginCard />
    </div>
  );
};

export default LoginPage;