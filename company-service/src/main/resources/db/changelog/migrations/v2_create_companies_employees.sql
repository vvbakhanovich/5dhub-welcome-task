CREATE TABLE IF NOT EXISTS companies_employees (
    company_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    CONSTRAINT fk_companies_employees FOREIGN KEY (company_id) references companies(id),
    CONSTRAINT unq_company_employee UNIQUE (company_id, employee_id)
);
