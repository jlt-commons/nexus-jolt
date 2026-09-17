# nexus

This repo is named `nexus-jolt` (matching its GitHub remote and `deps.edn`
coordinate) to disambiguate from upstream `cjohansen/nexus` and from the
`nexus.*` namespace prefix its own code uses — use `nexus-jolt` as the
dependency name.

A Jolt port of [nexus](https://github.com/cjohansen/nexus): data-driven
action/effect/placeholder dispatch. `nexus.core` is the dispatch engine;
`nexus.registry` is a registry-atom convenience API over it (register
effects/actions/placeholders once, `dispatch` against the accumulated
registry rather than threading a config map through every call site).

Extracted from [glitter](https://github.com/jlt-commons/glitter), where
it first shipped as `glitter.nexus`/`glitter.nexus.registry` — nothing in
either file is glitter-specific, so it now stands alone. See `NOTICE` for
full provenance.

## Quick start

```bash
jolt -M:test
```

## Status

Early — a straight port with no scope beyond what glitter's own usage
already exercised (`register-effect!`, `register-action!`,
`register-expansion!`, `register-placeholder!`, `on-error`, interceptors).
CHANGELOG and a docs guide are deferred until there's a second consumer.

## Licence

Copyright (c) 2026 Burin Choomnuan. Distributed under the
[Eclipse Public License 2.0](LICENSE). The ported nexus code keeps its
own MIT license — see [`NOTICE`](NOTICE).
