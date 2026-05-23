import sys


def install_sqlite_patch():
    try:
        import sqlite3  # noqa: F401
    except ModuleNotFoundError:
        import pysqlite3

        sys.modules['sqlite3'] = pysqlite3
