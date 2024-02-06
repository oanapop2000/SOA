import { Button, IconButton, TextField } from '@material-ui/core';
import AddCircleOutlineRoundedIcon from '@mui/icons-material/AddCircleOutlineRounded';
import React, { useState } from 'react';
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';
import axios from 'axios';

const style = {
  position: 'absolute' as 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  boxShadow: 24,
  pt: 2,
  px: 4,
  pb: 3,
};

export default function AddEventButton() {
  const [open, setOpen] = React.useState(false);
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [location, setLocation] = useState("");
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");

  const handleOpen = () => {
    setOpen(true);
  };
  const handleClose = () => {
    setOpen(false);
  };

  const user = JSON.parse(localStorage.getItem("user") || '{}');

  const addEvent = async () => {
    try {
      const response = await axios.post("http://localhost:82/calendar/events", {
        userId: user.id,
        eventName: name,
        eventDescription: description,
        location: location,
        startDate: startDate,
        endDate: endDate
      });
      debugger
      if (201 === response.status) {
        handleClose()
      }
    } catch (error) {
      window.alert("Please provide correct input!")
    }
  }

  return (
    <div>
      <IconButton onClick={handleOpen}><AddCircleOutlineRoundedIcon fontSize="large" /></IconButton>

      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="parent-modal-title"
        aria-describedby="parent-modal-description"
      >
        <Box sx={{ ...style, width: 400 }}>
          <div>
            <div>
              <TextField
               className="add-event-modal"
                id="outlined-basic"
                label="Name"
                variant="outlined"
                onChange={e => setName(e.target.value)}
              />
            </div>
            <div>
              <TextField
                id="outlined-basic"
                label="Description"
                variant="outlined"
                onChange={e => setDescription(e.target.value)}
              />
            </div>
            <div>
              <TextField
                id="outlined-basic"
                label="Location"
                variant="outlined"
                onChange={e => setLocation(e.target.value)}
              />
            </div>
            <div>
              <TextField
                id="outlined-basic"
                label="Start date"
                variant="outlined"
                onChange={e => setStartDate(e.target.value)}
              />
            </div>
            <div>
              <TextField
                id="outlined-basic"
                label="End date"
                variant="outlined"
                onChange={e => setEndDate(e.target.value)}
              />
            </div>
            <div>
              <Button onClick={addEvent} variant="contained" color='primary'>
                Create event
              </Button>
            </div>
          </div>
        </Box>
      </Modal>
    </div>
  );
};
