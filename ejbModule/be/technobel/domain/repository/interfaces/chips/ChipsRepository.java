/**
 * 
 */
package be.technobel.domain.repository.interfaces.chips;

import be.technobel.domain.entity.Chips;
import be.technobel.domain.repository.interfaces.GenericRepository;

/**
 * @author jonmeu
 *
 */

public interface ChipsRepository extends GenericRepository<Chips> {

	public Chips findByName(String name);
}
