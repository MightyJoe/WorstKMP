CREATE TABLE Inspection (
    id INTEGER PRIMARY KEY,
    title TEXT NOT NULL,
    status TEXT NOT NULL,
    created_at INTEGER NOT NULL
);

CREATE TABLE ChecklistItem (
    id INTEGER PRIMARY KEY,
    inspection_id INTEGER NOT NULL,
    question TEXT NOT NULL,
    completed INTEGER NOT NULL DEFAULT 0,
    notes TEXT,
    FOREIGN KEY (inspection_id) REFERENCES Inspection(id)
);

CREATE TABLE Photo (
    id INTEGER PRIMARY KEY,
    checklist_item_id INTEGER,
    file_path TEXT NOT NULL,
    timestamp INTEGER NOT NULL,
    FOREIGN KEY (checklist_item_id) REFERENCES ChecklistItem(id)
);

-- Queries
selectAllInspections:
SELECT * FROM Inspection;

insertInspection:
INSERT INTO Inspection(title, status, created_at)
VALUES (?, ?, ?);

