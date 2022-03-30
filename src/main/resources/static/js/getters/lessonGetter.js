'use strict';

window.addEventListener('DOMContentLoaded', async () => {
    const resource = 'http://localhost:8080/classrooms/'
    const elem = document.querySelector('.modal-body-buttons');
    const container = document.querySelector('#modal-hint');
    const observer = new MutationObserver(async (mutations) => {
        mutations.forEach((mutation) => {
            for(let node of mutation.addedNodes) {
                if (!(node instanceof HTMLElement)) continue;

                if (node.matches('form#FormToGetStudentSchedule') ||
                    node.matches('form#FormToGetProfSchedule') ||
                    node.matches('form#FormToGetClassroomSchedule')
                ){
                    node.addEventListener('submit', async (event) => {
                        event.preventDefault();
                        const data = new FormData(node);
                        const object = {};
                        data.forEach((value, key) => {
                            object[key] = value;
                        });
                        const resource = getLessonsResource(node, object);
                        delete object['classroom_id'];
                        delete object['professor_id'];
                        delete object['student_id'];
                        const responseData = await getData(resource, container, object, elem);
                        if (responseData.length === 0) {
                            document.querySelector('div.container-md').textContent = 'По вашему запросу ничего не нашлось.'
                        }
                        responseData.forEach((elem, index) => {
                            displayLessons(elem, index, object);
                        });
                        container.textContent = 'Данные успешно загружены!'
                    });
                }
            }
        });
    });
    const config = {childList: true, subtree: true};
    observer.observe(elem, config);
});