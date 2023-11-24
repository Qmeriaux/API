BEGIN;

INSERT INTO bookings(id, flightId, passengerId) VALUES
                                                    (NEXTVAL('bookings_sequence'), 1, 1);
COMMIT;
