import React from 'react';
import './activityPlannerPage.css';
import TableEvents from '../../components/table/table';
import AddEventButton from '../../components/addEventButton/addEventButton';

const ActivityPlannerPage: React.FC = () => {
  const user = JSON.parse(localStorage.getItem("user") || '{}');

  return (
    <div className='activity-planner-page'>
      <h1>
        {"Hello, " + user.firstName + "!"}
      </h1>
      <TableEvents />
      <AddEventButton />
    </div>
  );
};

export default ActivityPlannerPage;