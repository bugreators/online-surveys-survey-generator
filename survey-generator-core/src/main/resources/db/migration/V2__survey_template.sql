CREATE SCHEMA IF NOT EXISTS survey_templates;

CREATE TABLE IF NOT EXISTS survey_templates.survey_templates(
    id bigserial not null primary key ,
    name text not null
);

CREATE TABLE IF NOT EXISTS survey_templates.users_survey_templates(
    id bigserial not null primary key ,
    user_id bigserial references users.users(id),
    survey_template_id bigserial references survey_templates.survey_templates(id)
);

CREATE TABLE IF NOT EXISTS survey_templates.survey_question(
    id bigserial primary key ,
    text text ,
    survey_template_id bigserial references survey_templates.survey_templates(id)
);
