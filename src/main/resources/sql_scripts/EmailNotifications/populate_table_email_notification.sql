use my_db;

INSERT INTO `email_notification` (`type`, `to`, `cc`, `subject`, `body`)
VALUES (
	'Sent Questions',
    'walkuhdan@gmail.com',
    'gallahanm@gmail.com; walkuhdan@yahoo.com;',
    'Test Email 1',
    'This is the body for an email1. This is the body for an email1. This is the body for an email1. This is the body for an email1.'
    );

INSERT INTO `email_notification` (`type`, `to`, `cc`, `subject`, `body`)
VALUES (
	'Agency Response Due Reminder',
    'walkuhdan@gmail.com',
    'gallahanm@gmail.com; walkuhdan@yahoo.com;',
    'Test Email 2',
    'This is the body for an email2. This is the body for an email2. This is the body for an email2. This is the body for an email2.'
    );
