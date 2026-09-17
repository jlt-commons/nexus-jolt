# Contributing

## Build and test

```bash
jolt -M:test
```

That's the whole gate. There's no separate lint/format task configured
in this repository yet — if you add one, update this page.

## Provenance rules for ported code

Both `src/nexus/core.clj` and `src/nexus/registry.clj` are ports of
upstream [nexus](https://github.com/cjohansen/nexus). `NOTICE` is the
authoritative record of exactly which upstream commit they were ported
from and what, if anything, was adapted for Jolt.

Before changing either file:

1. Read its entry in `NOTICE` — `nexus.registry` is a byte-for-byte
   port with zero adaptations; `nexus.core` has exactly one
   Jolt-specific adaptation (documented in its own ns docstring and in
   `NOTICE`).
2. If your change touches upstream behavior (not just a Jolt-specific
   adaptation), consider whether the fix belongs upstream instead —
   this package exists to carry a faithful port forward, not to
   diverge from it without a documented reason.
3. Update `NOTICE` if your change adds a new deviation from upstream,
   so the next person reading it has an accurate record.

## Namespace names match upstream nexus, not the pre-extraction names

This package uses `nexus.core`/`nexus.registry` — the same names
upstream `cjohansen/nexus` uses — not `glitter.nexus`/
`glitter.nexus.registry`, which is what these files were called while
they still lived inside `glitter`. That rename was deliberate, part of
the 2026-09-17 extraction. A consumer still requiring
`glitter.nexus`/`glitter.nexus.registry` needs fixing on the consumer's
side, not here.

## Reporting issues

Open an issue on [this repository](https://github.com/jlt-commons/nexus-jolt/issues).
If the issue is actually about upstream nexus behavior rather than
something specific to this port, consider filing it upstream instead —
see `NOTICE` for the exact upstream commit this package was ported
from.
