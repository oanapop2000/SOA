import { Button, TextField } from '@material-ui/core';
import './loginCard.css';
import { useState } from 'react';
import { Link, useNavigate } from "react-router-dom";
import axios from 'axios';


export function LoginCard() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const logIn = async () => {
    try {
      const response = await axios.post("http://localhost:80/user/users/user", {
        username: username,
        password: password
      });
      debugger
      if (200 === response.status) {
        localStorage.setItem("user", JSON.stringify(response.data))
        navigate("/planner")
      } 
    } catch (error) {
      window.alert("Wrong username or password")
    }
  }

  return (
    <div className="login-card">
      <div>
        <TextField id="outlined-basic" label="Username" variant="outlined" onChange={e => setUsername(e.target.value)} />
      </div>
      <div>
        <TextField id="outlined-password-input" label="Password" variant="outlined" type="password" onChange={e => setPassword(e.target.value)} />
      </div>
      <div>
        <Link className="link" to='/register'>Not having an account yet? Please register here!</Link>
      </div>
      <div>
        <Button className="login-button" onClick={logIn} variant="contained" color='primary'>Login</Button>
      </div>
    </div>
  );
};

export default LoginCard;