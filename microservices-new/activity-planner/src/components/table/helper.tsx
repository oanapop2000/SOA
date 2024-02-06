import useSWR from 'swr';

const user = JSON.parse(localStorage.getItem("user") || '{}');
const url = 'http://localhost:82/calendar/events/userId/' + user.id;

async function getEvents() {
  const response = await fetch(url);
  return response.json();
}
export default function useEvents() {
  const { data, isValidating } = useSWR(url, getEvents);
  return {
    data: data ?? [],
    isValidating,
  };
}