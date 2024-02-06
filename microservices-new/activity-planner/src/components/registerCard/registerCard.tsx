import { Button, TextField } from '@material-ui/core';
import './registerCard.css';
import { useState } from 'react';
import { Link, useNavigate } from "react-router-dom";
import axios from 'axios';


export function RegisterCard() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const navigate = useNavigate();

  const register = async () => {
    try {
      const response = await axios.post("http://localhost:80/user/register", {
        lastName: lastName,
        email: email,
        firstName: firstName,
        password: password,
        username: username
      });
      debugger
      if (200 === response.status) {
        localStorage.setItem("user", JSON.stringify({ username }))
        navigate("/")
      }
    } catch (error) {
      window.alert("The user could not be created!")
    }
  }

  return (
    <div className="register-card">
      <div>
        <TextField
          id="outlined-basic"
          label="First name"
          variant="outlined"
          onChange={e => setFirstName(e.target.value)}
        />
      </div>
      <div>
        <TextField
          id="outlined-basic"
          label="Last name"
          variant="outlined"
          onChange={e => setLastName(e.target.value)}
        />
      </div>
      <div>
        <TextField
          id="outlined-basic"
          label="Username"
          variant="outlined"
          onChange={e => setUsername(e.target.value)}
        />
      </div>
      <div>
        <TextField
          id="outlined-basic"
          label="Email"
          variant="outlined"
          onChange={e => setEmail(e.target.value)}
        />
      </div>
      <div>
        <TextField
          id="outlined-password-input"
          label="Password"
          type="password"
          variant="outlined"
          onChange={e => setPassword(e.target.value)}
        />
      </div>
      <div className="register-button">
        <Button onClick={register} variant="contained" color='primary'>
          Create account
        </Button>
      </div>
    </div>
  );
};

export default RegisterCard;