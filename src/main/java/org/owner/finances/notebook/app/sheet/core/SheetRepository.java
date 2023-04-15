package org.owner.finances.notebook.app.sheet.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SheetRepository extends JpaRepository<Sheet, Long>
{
    Sheet findBySheetID(Long sheetID);
    Sheet findBySheetIDAndUserUsername(Long sheetID, String username);
}
