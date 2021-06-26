#!/usr/bin/env bash

set -m

/entrypoint.sh couchbase-server &

sleep 15

curl -v -X POST http://127.0.0.1:8091/pools/default -d memoryQuota=512 -d indexMemoryQuota=512

curl -v http://127.0.0.1:8091/node/controller/setupServices -d services=kv%2cn1ql%2Cindex

curl -v http://127.0.0.1:8091/settings/web -d port=8091 -d username="$COUCHBASE_ADMINISTRATOR_USERNAME" -d password="$COUCHBASE_ADMINISTRATOR_PASSWORD"

curl -i -u "$COUCHBASE_ADMINISTRATOR_USERNAME":"$COUCHBASE_ADMINISTRATOR_PASSWORD" -X POST http://127.0.0.1:8091/settings/indexes -d 'storageMode=memory_optimized'

# shellcheck disable=SC2086
curl -v -u $COUCHBASE_ADMINISTRATOR_USERNAME:$COUCHBASE_ADMINISTRATOR_PASSWORD -X POST http://127.0.0.1:8091/pools/default/buckets -d name="$COUCHBASE_BUCKET" -d bucketType=couchbase -d ramQuotaMB=128 -d authType=sasl -d saslPassword=$COUCHBASE_BUCKET_PASSWORD

sleep 15

# shellcheck disable=SC2006
# shellcheck disable=SC2140
curl -v http://127.0.0.1:8091/query/service -d "statement= CREATE INDEX reviews ON default(_class) WHERE (_class = 'sp.mycustom.reviewservice.entities.Review')"
# shellcheck disable=SC2140
curl -v http://127.0.0.1:8091/query/service -d "statement= CREATE INDEX movies ON default(_class) WHERE (_class = 'sp.mycustom.reviewservice.entities.Movie')"
fg 1