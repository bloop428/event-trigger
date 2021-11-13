package gg.xp.events.models;


import org.jetbrains.annotations.Nullable;

public class XivCombatant extends XivEntity {

	private static final long serialVersionUID = -6395674063997151018L;
	private final boolean isPc;
	private final boolean isThePlayer;
	private final long rawType;
	// Marking as nullable for now until I figure out party members more
	private final @Nullable HitPoints hp;
	private final @Nullable Position pos;
	private final long bNpcId;
	private final long bNpcNameId;
	private final long partyType;
	private final long level;
	private final long ownerId;
	// TODO: location/heading
	// TODO: hp info

	public XivCombatant(
			long id,
			String name,
			boolean isPc,
			boolean isThePlayer,
			long rawType,
			@Nullable HitPoints hp,
			@Nullable Position pos,
			long bNpcId,
			long bNpcNameId,
			long partyType,
			long level,
			long ownerId
	) {
		super(id, name);
		this.isPc = isPc;
		this.isThePlayer = isThePlayer;
		this.rawType = rawType;
		this.hp = hp;
		this.pos = pos;
		this.bNpcId = bNpcId;
		this.bNpcNameId = bNpcNameId;
		this.partyType = partyType;
		this.level = level;
		this.ownerId = ownerId;
	}

	/**
	 * Simplified ctor for entity lookups that miss
	 *
	 * @param id
	 * @param name
	 */
	public XivCombatant(long id, String name) {
		this(id, name, false, false, 0, null, null, 0, 0, 0, 0, 0);
	}


	public boolean isPc() {
		return isPc;
	}

	public boolean isThePlayer() {
		return isThePlayer;
	}

	@Override
	public String toString() {
		if (isEnvironment()) {
			return super.toString();
		}
		return String.format("XivCombatant(0x%X:%s)", getId(), getName());
	}

	// TODO: replace the others with this
	public CombatantType getType() {
		if (isPc()) {
			return CombatantType.PC;
		}
		else {
			return CombatantType.NPC;
		}
	}

	public long getRawType() {
		return rawType;
	}

	public @Nullable HitPoints getHp() {
		return hp;
	}

	public @Nullable Position getPos() {
		return pos;
	}

	public long getbNpcId() {
		return bNpcId;
	}

	public long getbNpcNameId() {
		return bNpcNameId;
	}

	public long getPartyType() {
		return partyType;
	}

	public long getLevel() {
		return level;
	}

	public long getOwnerId() {
		return ownerId;
	}
}
