#!/bin/bash
cd build
rename SendEmailService.jar SendEmailService-%build.number%.jar
cd ..