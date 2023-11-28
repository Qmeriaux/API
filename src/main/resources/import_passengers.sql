BEGIN;

INSERT INTO passengers(id, lastname, firstname, email) VALUES
                                                        (NEXTVAL('passengers_sequence'), 'Doe', 'John', 'dj@d.j'),
                                                        (NEXTVAL('passengers_sequence'), 'Doe', 'Jane', 'dj2@d.j'),
                                                        (NEXTVAL('passengers_sequence'), 'Doe', 'Jack', 'dj3@d.j'),
                                                        (NEXTVAL('passengers_sequence'), 'Doe', 'Jill', 'dj4@d.j');
COMMIT;
