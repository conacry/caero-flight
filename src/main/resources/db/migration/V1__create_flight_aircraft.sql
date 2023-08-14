CREATE TABLE IF NOT EXISTS public.flight
(
    id                      uuid PRIMARY KEY,
    number                  text NOT NULL,
    departure_airport_id    text NOT NULL,
    arrival_airport_id      text NOT NULL,
    aircraft_id             text NOT NULL,
    scheduled_departure     text NOT NULL,
    scheduled_arrival       text NOT NULL,
    actual_departure        timestamptz,
    actual_arrival          timestamptz,
    status                  text NOT NULL,
    created_at              text NOT NULL,
    updated_at              text NOT NULL
);

CREATE TABLE IF NOT EXISTS public.aircraft
(
    id      uuid PRIMARY KEY,
    model   text NOT NULL
);