BEGIN;

INSERT INTO flights(id, number, origin, destination, departure_date, departure_time, arrival_date, arrival_time, plane_id) VALUES
(NEXTVAL('flights_sequence'), 'AA 100', 'LAX', 'JFK', '2019-01-01', '10:00', '2019-01-01', '18:00', 1),
(NEXTVAL('flights_sequence'), 'AA 101', 'JFK', 'LAX', '2019-01-01', '10:00', '2019-01-01', '18:00', 1),
(NEXTVAL('flights_sequence'), 'AA 102', 'LAX', 'JFK', '2019-01-02', '10:00', '2019-01-02', '18:00', 1),
(NEXTVAL('flights_sequence'), 'AA 103', 'JFK', 'LAX', '2019-01-02', '10:00', '2019-01-02', '18:00', 1),
(NEXTVAL('flights_sequence'), 'AA 104', 'LAX', 'JFK', '2019-01-03', '10:00', '2019-01-03', '18:00', 1),
(NEXTVAL('flights_sequence'), 'AA 105', 'JFK', 'LAX', '2019-01-03', '10:00', '2019-01-03', '18:00', 1),
(NEXTVAL('flights_sequence'), 'AA 106', 'LAX', 'JFK', '2019-01-04', '10:00', '2019-01-04', '18:00', 1),
(NEXTVAL('flights_sequence'), 'AA 107', 'JFK', 'LAX', '2019-01-04', '10:00', '2019-01-04', '18:00', 1),
(NEXTVAL('flights_sequence'), 'AA 108', 'LAX', 'JFK', '2019-01-05', '10:00', '2019-01-05', '18:00', 1),
(NEXTVAL('flights_sequence'), 'AA 109', 'JFK', 'LAX', '2019-01-05', '10:00', '2019-01-05', '18:00', 1),
(NEXTVAL('flights_sequence'), 'AA 110', 'LAX', 'JFK', '2019-01-06', '10:00', '2019-01-06', '18:00', 1);
COMMIT;
