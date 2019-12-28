DROP SCHEMA IF EXISTS surveys cascade;
CREATE SCHEMA IF NOT EXISTS surveys;

CREATE TABLE IF NOT EXISTS surveys.recipient
(
    id     bigserial primary key,
    email  text not null,
    status boolean
);

CREATE TABLE IF NOT EXISTS surveys.surveys
(
    id       bigserial primary key,
    status   boolean   not null,
    amount   integer   not null,
    end_time timestamp not null
);

CREATE TABLE IF NOT EXISTS surveys.surveys_recipients
(
    id                  bigserial primary key,
    recipient_id        bigserial references surveys.recipient (id),
    survey_recipient_id bigserial references surveys.surveys_recipients (id)
);

CREATE TABLE IF NOT EXISTS surveys.report
(
    id        bigserial primary key,
    survey_id bigserial references surveys.surveys (id)
);

CREATE TABLE IF NOT EXISTS surveys.surveys_answers
(
    id        bigserial primary key,
    status    boolean not null,
    survey_id bigserial references surveys.surveys (id)
);
CREATE TABLE IF NOT EXISTS surveys.question_answers
(
    id          bigserial primary key,
    question_id bigserial references survey_templates.survey_question (id),
    answer      integer
);
