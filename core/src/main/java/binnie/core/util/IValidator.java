package binnie.core.util;

import javax.annotation.Nullable;

public interface IValidator<V> {
	boolean isValid(@Nullable V value);
}
