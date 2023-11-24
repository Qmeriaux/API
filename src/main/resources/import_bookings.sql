BEGIN;

INSERT INTO bookings(id, flightId, passengerId) VALUES
                                                    (NEXTVAL('bookings_sequence'), 1, 1),
                                                    (NEXTVAL('bookings_sequence'), 1, 2),
                                                    (NEXTVAL('bookings_sequence'), 1, 3),
                                                    (NEXTVAL('bookings_sequence'), 2, 4);
COMMIT;
