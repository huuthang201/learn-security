9. Kiểm thử với curl
Public

```bash
curl -i http://localhost:8080/api/hello
# 200 OK
```
USER

```bash
curl -i -u user:user http://localhost:8080/api/user
# 200 OK
curl -i -u user:user http://localhost:8080/api/admin
# 403 Forbidden
```
ADMIN

```bash
curl -i -u admin:admin http://localhost:8080/api/admin
# 200 OK
curl -i -u admin:admin http://localhost:8080/api/user
# 200 OK  (vì admin cũng có ROLE_USER)
```
