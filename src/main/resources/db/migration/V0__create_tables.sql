CREATE TABLE IF NOT EXISTS public.airport
(
    id                   uuid PRIMARY KEY,
    airport_code         text NOT NULL UNIQUE,
    airport_name         text NOT NULL,
    city_name            text NOT NULL,
    latitude_coordinate  text NOT NULL,
    longitude_coordinate text NOT NULL,
    timezone             text NOT NULL
);