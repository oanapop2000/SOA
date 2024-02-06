import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import "./table.css";
import { IconButton } from '@material-ui/core';
import DeleteIcon from '@mui/icons-material/Delete';
import useEvents from './helper';
import { useEffect, useState } from 'react';
import { Event } from './event';
import axios from 'axios';

const deleteEvent = async (eventId: number) => {
  try {
    debugger
    await axios.delete("http://localhost:82/calendar/events/delete/" + eventId.toString(),);
  } catch (error) {
    window.alert("The delete request could not be finished!")
  }
}

export default function TableEvents() {
  const { data: originalData, isValidating } = useEvents();
  const [data, setData] = useState<Event[]>([]);
  const [editedRows, setEditedRows] = useState({});
  const [validRows, setValidRows] = useState({});

  useEffect(() => {
    if (isValidating) return;
    setData([...originalData]);
  }, [isValidating]);

  return (
    data.length !== 0 ?
      <TableContainer className='table' component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell className='table-cell'>Name</TableCell>
              <TableCell className='table-cell' align="right">Description</TableCell>
              <TableCell className='table-cell' align="right">Location</TableCell>
              <TableCell className='table-cell' align="right">Start date</TableCell>
              <TableCell className='table-cell' align="right">End date</TableCell>
              <TableCell className='table-cell' align="right" />
            </TableRow>
          </TableHead>
          <TableBody>
            {data.map((event) => (
              <TableRow
                key={event.id}
                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {event.eventName}
                </TableCell>
                <TableCell align="right">{event.eventDescription}</TableCell>
                <TableCell align="right">{event.location}</TableCell>
                <TableCell align="right">{event.startDate.substring(0, 10)}</TableCell>
                <TableCell align="right">{event.endDate.substring(0, 10)}</TableCell>
                <TableCell align="right"><IconButton onClick={() => deleteEvent(event.id)}><DeleteIcon /></IconButton></TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      : null
  );
}
